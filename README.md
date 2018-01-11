# Linear Regression Gradient Descent in java

```
// Auto convergence. Technique used is to check if error not changed for 100 iteration.
GradientDescent descent = new LinearRegressionGradientDescent(dataset, targets, lr);

// Convergence By Max number of iterations.
GradientDescent descent = new LinearRegressionGradientDescent(dataset, targets, lr, int maxItr)
```

Please review sample code at src/com/sigmoid/test/LinearRegressionGDTest.java
