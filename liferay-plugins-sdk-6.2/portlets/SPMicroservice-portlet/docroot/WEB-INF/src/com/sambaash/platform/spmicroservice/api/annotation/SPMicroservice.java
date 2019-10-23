package com.sambaash.platform.spmicroservice.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Annotate to class
@Retention(RetentionPolicy.RUNTIME) 
public @interface SPMicroservice {
	String value();
}
