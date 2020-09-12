package com.features;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ProcessImprovements {

    public static void main(String[] args) throws IOException {
        // getPid()
        ProcessHandle current = ProcessHandle.current();
        System.out.println("Current processo ID " + current.pid());

        // startPipeline()
        ProcessBuilder ls = new ProcessBuilder()
                .command("ls")
                .directory(Paths.get("/tmp").toFile());
        ProcessBuilder wc = new ProcessBuilder()
                .command("wc", "-l")
                .redirectOutput(ProcessBuilder.Redirect.INHERIT);
        List<Process> lsPipeWc = ProcessBuilder
                .startPipeline(List.of(ls, wc));
    }

}
