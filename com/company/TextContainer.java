package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@SaveToFile(path = "D/java/bpbpbpbopb")
public class TextContainer {
    @Content
    String txt = "sdfghjk";
    @Saver
    public void writer(String path, String text) throws IOException {
        File someFile = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(text);
    }

    public void magic() {
        Method method = null;
        Field f2 = null;

        String path = null;
        for (Method m : TextContainer.class.getMethods()) {
            if (m.isAnnotationPresent(Saver.class)) {
                method = m;

            }

            SaveToFile annot = (SaveToFile) TextContainer.class.getAnnotation(SaveToFile.class);
            path = annot.path();
            for (Field f : TextContainer.class.getFields()) {
                if (f.isAnnotationPresent(Content.class)) {
                    f2 = f;
                }
            }
        }
        try {
            method.invoke(path, f2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
