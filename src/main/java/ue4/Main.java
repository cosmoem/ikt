package ue4;

import de.htwberlin.fiw.profiler.Profiler;

public class Main {

    public static void main(String[] args) {

        Profiler profiler = new Profiler(ProfilerUndirectedGraph.class);
        profiler.start();
        profiler.printResults();
    }
}