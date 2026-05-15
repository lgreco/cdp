# Configuration file for the Sphinx documentation builder.
#
# This file only contains a selection of the most common options. For a full
# list see the documentation:
# http://www.sphinx-doc.org/en/master/config

# -- Path setup --------------------------------------------------------------

# If extensions (or modules to document with autodoc) are in another directory,
# add these directories to sys.path here. If the directory is relative to the
# documentation root, use os.path.abspath to make it absolute, like shown here.
#
# import os
# import sys
# sys.path.insert(0, os.path.abspath('.'))







# -- Project information -----------------------------------------------------

project = 'Leo Irakliotis\' courses'
copyright = '2019-2026, Leo Irakliotis'
author = 'Leo Irakliotis'


# -- General configuration ---------------------------------------------------

root_doc = 'index'

# Add any Sphinx extension module names here, as strings. They can be
# extensions coming with Sphinx (named 'sphinx.ext.*') or your custom
# ones.
extensions = [
    "sphinxcontrib.gist",
    "sphinx.ext.githubpages", # needed for GH actions
    "sphinx.ext.autosectionlabel",
]

autosectionlabel_prefix_document = True

# allows sphinx to ignore errors in parsing ipynb files
# to be used with nbsphinx extenesion after it is added to 
# extensions above. Note that this extension will render
# every ipynb file it encounters, so I have removed it for
# now because it's not really very useful. All I wanted 
# was an equivalent to includeliteral for ipynb files.
# 23 FEB 2020 
#nbsphinx_allow_errors = True
#exclude_patterns = ['_build', '**.ipynb_checkpoints']

# Add any paths that contain templates here, relative to this directory.
templates_path = ['_templates']

# List of patterns, relative to source directory, that match files and
# directories to ignore when looking for source files.
# This pattern also affects html_static_path and html_extra_path.
exclude_patterns = ['_build', 'Thumbs.db', '.DS_Store']


# -- Options for HTML output -------------------------------------------------

# The theme to use for HTML and HTML Help pages.  See the documentation for
# a list of builtin themes.
#
html_theme = "sphinx_book_theme"

html_title = "Leo Irakliotis' Courses"
html_last_updated_fmt = "%B %d, %Y"
