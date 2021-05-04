
Review of Week 5
=======================================================

The Wisconsin Breast Cancer data set and the notebook used in class, are `available from our Github repository <https://github.com/lgreco/cdp/tree/master/source/COMP180/code/WBC>`_. To download the files, open them in Raw view, then right-click (or go to the browser's File menu) and Save As.

This notebook is our first step into correlation. Correlation measures how two (or more) variables resemble each other in behavior. We study correlation to uncover causation, i.e., some direct or indirect evidence that one variable determines the behavior of the other. As an example, we discussed how taller people tend to be heavier. This correlation has a causal basis: a taller person has more mass and therefore weighs more than a shorter person. We also discussed `spurious correlations <https://www.tylervigen.com/spurious-correlations>`_, i.e., behaviors that look similar but have no reasonable or objective relation.

Given two random variables :math:`X` and :math:`Y`, whose expected values are :math:`\mu_x` and :math:`\mu_y` respectively, their correlation is defined as:

.. math::
   
   \rho_{X,Y} = \frac{\mathrm{cov}(X,Y)}{(\sigma_X\sigma_Y)}

where :math:`\sigma_X` and :math:`\sigma_Y` are the respective standard deviations. As a reminder, if the probability for outcome :math:`x_l` is :math:`p_l`, then 

.. math::
  \mu_X &= \sum_{i=1}^k x_i p_i \\ \\
  \sigma_X &= \left( \left(\sum_{i=1}^{k} x_i^2 p_i\right)-\mu_X\right)^{1/2} \\ \\
  \mathrm{cov}(X,Y) &= \frac{1}{n} \sum_{i=1}^{k} (x_i-\mu_X)(y_i-\mu_Y) \\
  &= \frac{1}{n^2} \sum_{i=1}^{k} \sum_{j=i}^{k} \frac{1}{2} (x_i-x_j)(y_i-y_j)
  
And after substitutions, we can write that

.. math::
   
   \rho_{X,Y} = \frac{ \sum_{i=1}^{k} (x_i-\bar{x})(y_i-\bar{y})} { \sqrt{\sum_{i=1}^{k} (x_i-\bar{x})^2} \sqrt{\sum_{i=1}^{k} (y_i-\bar{y})^2} }

where :math:`\bar{x}=\frac{1}{k}\sum_{i=1}^k x_i`, and likewise for :math:`\bar{y}`.

Luckily for us, this analysis is done within the ``seaborn`` package. This package is an extension (library) in Python, built on top of the ``mathplotlib`` library, to provide statistical analysis and visualization. 

Useful information about the ``seaborn`` package
-------------------------------------------------

* `The project's website <https://seaborn.pydata.org/index.html>`_.
* Various `tutorials <https://seaborn.pydata.org/tutorial.html>`_ of which the one on `multiplot grids <https://seaborn.pydata.org/tutorial/axis_grids.html>`_ is particularly interesting.