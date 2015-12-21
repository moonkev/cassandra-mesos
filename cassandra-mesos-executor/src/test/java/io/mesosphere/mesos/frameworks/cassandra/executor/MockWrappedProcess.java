package io.mesosphere.mesos.frameworks.cassandra.executor;

public class MockWrappedProcess implements WrappedProcess {
    private final int pid;
    private final int statusToSet;
    
    private int exitCode = -1;

    public MockWrappedProcess(final int pid) {
        this(pid, 0);
    }

    public MockWrappedProcess(final int pid, final int statusToSet) {
        this.pid = pid;
        this.statusToSet = statusToSet;
    }

    @Override
    public int getPid() {
        return pid;
    }

    @Override
    public void destroy() {
        exitCode = statusToSet;
    }

    @Override
    public void destroyForcibly() {
    }

    @Override
    public int exitValue() {
        if (exitCode == -1) {
            throw new IllegalThreadStateException();
        }
        return exitCode;
    }
}
