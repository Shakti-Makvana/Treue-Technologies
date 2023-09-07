package de.leostrakosch.reminder.common;

/**
 * This exception will be thrown when a feature uses a new method signature and
 * wants to forbid the older one. E.a the feature date uses only tasks with
 * date, tasks without date will result in a Runtime Error. To detect these
 * RuntimeError as early as possible the forbidden methods will be overritten
 * and throw this Exception.
 * 
 * Hopfully FeatrueIDE will support this mechanism nativly
 */
public class FeatureRuntimeError extends RuntimeException {
	private static final String FEATURE_ERROR_MESSAGE = "A method is called which a feature does not allow with its new ";

	public FeatureRuntimeError(String message) {
		super(FEATURE_ERROR_MESSAGE + '\n' + message);
	}

	public FeatureRuntimeError(String featureName, String message) {
		super(featureName.toUpperCase() + ": " + FEATURE_ERROR_MESSAGE + '\n'
				+ message);
	}
}