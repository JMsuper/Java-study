package com.jm.first;

import java.lang.annotation.Documented;

@Documented
public @interface ClassPreamble {
    String author();
    String data();
}
