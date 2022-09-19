package com.jm.first;

@ClassPreamble(
        author = "jm",
        data = "dataSet"
)
public class AnnotationTest {

    /**
     * @deprecated
     * explanation of why it was deprecated
     */
    @Deprecated
    public void method(){}
}
