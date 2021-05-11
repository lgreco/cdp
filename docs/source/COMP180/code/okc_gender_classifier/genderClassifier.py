#!/usr/bin/env python
# coding: utf-8

#
# genderClassifier
# Leo Irakliotis leo@cs.luc.edu
#
# This notebook is based on the okCupid dataset and provides a simple
# example of the solution for the final exam in COMP 180 001 SP 2020
# course in data science.
#
# The objective of the final exam was to determine if the the gender of
# okCupid users can be predicted based on the words found in these
# individuals' dating profiles. The notebook extracts words from the
# ten essays users write about themselves, and creates a binary TDIDF 
# space to mark the presence or absence of a word in a profile. This
# binary vector then is matched to the user's gender.


# Dependences:

import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split  
from sklearn.naive_bayes import GaussianNB   
from sklearn.svm import SVC
from sklearn.metrics import accuracy_score, confusion_matrix
from sklearn.feature_extraction.text import TfidfVectorizer
from nltk.corpus import stopwords 
from nltk.tokenize import RegexpTokenizer
from nltk.stem import PorterStemmer
from nltk.stem import LancasterStemmer
from nltk.stem import WordNetLemmatizer 


###
### GLOBAL VARIABLES
###

### Stopwords

STOPWORDS = stopwords.words('english')

### regex tokenizer to clean up strings from punctuation
###   and other undesirable characters

TOKENIZER = RegexpTokenizer(r"\w+")

### Lemmatizer.
### This step is not necessary for the COMP 180 001 SP20 final,
### but it helps here reduce the side of the allWords dictionary.

LEMMATIZER = WordNetLemmatizer()

### Stemmer -- we have a choice between Porter or Lancaster 
###   stemming; we use Porter for now, in the interest of 
###   faster performance. 
### This step is not necessary for the COMP 180 001 SP20 final,
### but it helps here reduce the side of the allWords dictionary.

STEMMER = LancasterStemmer()

### File with dataset.
###   Notice that we are reading from a ZIPed file. Pandas read_csv
###   can detect the file type, unzip it, then read the CSV. The use
###   of zip is necessary to bypass Github's file size limit of 100 MB.
###   Uncompressed, the datase is about 145 MB and cannot be uploaded
###   to GH; however the zip'd file is 56 MB.

FILE = "profiles.zip"

### Attributes we are interested in.
###   The dataset contains multiple columns, however our analysis 
###   focuses only on the the essays labeled essay0, essay, ...,
###   and the gender of the user, labeled sex.
###   In terms of classifier data structures, our ATTRIBUTES
###   comprise two components: FEATURES and TARGET.

FEATURES = [
    'essay0', 
    'essay1',
    'essay2',
    'essay3', 
    'essay4',
    'essay5',
    'essay6', 
    'essay7',
    'essay8',
    'essay9']

TARGET = ['sex']

ATTRIBUTES = FEATURES + TARGET

### Number of rows to import from the dataset.
###   The dataset contains about 60000 records and importing all of
###   them will overwhelm most systems. Therefore we import a fraction
###   of them, for development purposes.

NROWS = 100

# Read the dataset into a dataframe
rawData = pd.read_csv(FILE, usecols=ATTRIBUTES, nrows=NROWS)

# Replacing gender m/f with 0/1 in column sex
rawData[TARGET] = rawData[TARGET].replace({'m':0,'f':1})


#
# allWords : a set of all words used in all essays all users. 
#   To create this set, we iterate the dataframe, one row at a time,
#   tokenize each essay, turn the list of tokens into a set, add
#   that set (via a union) to the set of words found in the 
#   specific user's essays, and finally add that set to allWords.
#   We take this piecemeal approach to keep memory demands manageable.
#   If memory resources were not an issue then we can first merge all
#   essays, then tokenize, then unionize etc. But for now priority is
#   given to operations with the smallest possible memory footprint.

allWords = set()

# LOOP over all records in dataframe
for index,row in rawData.iterrows(): 
    lemmatizedAndStemmed = []
    # LOOP over each essay per record (essay names are stored in FEATURES)
    for e in FEATURES:
        # IF essay is not empty, tokenize it
        if pd.notna(row[e]):
            essayTokens = TOKENIZER.tokenize(row[e])
        # CONVERT essay tokens into set to reduce size by removing
        # duplicate words.
        essayTokensSet = set(essayTokens)
        # LOOP over each element of the tokens set, lemmatize it,
        # then stem it, then append to lemmatized/stemmed list
        for w in essayTokensSet:                       # Notice that this step was not
            lemma = LEMMATIZER.lemmatize(w)            # required for the final exam but
            stemmedLemma = STEMMER.stem(lemma)         # I include it here because it is 
            lemmatizedAndStemmed.append(stemmedLemma)  # useful and better than stopwords!
    #
    # CONVERT list of stemmed lemmas to a set and union that set with the
    # set of all words, in all essays, by all users.
    userwords = set(lemmatizedAndStemmed)
    allWords = allWords.union(userwords)

##### at this point we can filter allWords against stopWords if we want to. The code
##### is provided for completion but is commented out. It's effect, on a properly
##### lemmatized/stemmed set is minimal. For NROWS=10000, the set of stemmed lemmas
##### had a cardinality of 40693. When removing stop words, the cardinality dropped
##### by only ~120 items, to 40577. Not worth it. We'll proceed with using the
##### allWords set in the remaining of this notebook.
#####
##### allWordsCleaned = []
##### for w in allWords:
#####     if w not in stopWords:
#####         allWordsCleaned.append(w)


# We prepare dataframes X, Y for use with standard sklearn classifier API.
# Dataframe X is the binary TDIDF for the essays, while Y is the 
# corresponding gender. 
#
# Creating Y is straightforward. 
#
# X is created as a new dataframe with as many # rows are records and whose 
# columns correspond to the elements of allWords, and all its values set to 0.
# Next we scan rawData one more time, tokezining, lemmatizing, and stemming 
# the essays, using each term as a column reference to indicate the terms
# presence in the corresponding user record.

Y = rawData[TARGET].values.ravel()
X = pd.DataFrame(0,index=np.arange(len(rawData)),columns=allWords)

for index, row in rawData.iterrows():
    for e in FEATURES:
        if pd.notna(row[e]):
            essayTokens = TOKENIZER.tokenize(row[e])
            essayTokens = set(essayTokens)
            for t in essayTokens:
                lemma = LEMMATIZER.lemmatize(t)
                stem = STEMMER.stem(lemma)
                # change the value at essayVectors(index, stem) to 1
                X.loc[index,stem] = 1    


# Prepare training and testing dataframes

X_train, X_test, Y_train, Y_test = train_test_split(X,Y, test_size=0.2, random_state=44)


# Gaussian Naive Bayes classifier

classifier = GaussianNB()
training = classifier.fit(X_train, Y_train)
Y_predicted = classifier.predict(X_test) 
accuracy = accuracy_score(Y_test, Y_predicted)
print("GaussianNB accurancy is",accuracy)

# SVM classifier

classifier = SVC()
training = classifier.fit(X_train, Y_train)
Y_predicted = classifier.predict(X_test) 
accuracy = accuracy_score(Y_test, Y_predicted)
print("SVC accurancy is",accuracy)