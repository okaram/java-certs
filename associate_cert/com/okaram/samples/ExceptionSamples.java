package com.okaram.samples;

public class ExceptionSamples {
    public static
    class MyException extends Exception {
        public MyException(String message){
            super(message);
        }
    }

    public static
    class MyRuntimeException extends RuntimeException {
        public MyRuntimeException(String message){
            super(message);
        }
    }

    public static enum ExceptionToThrow{ CHECKED, RUNTIME, NONE};

    public static 
    void throwExceptions(ExceptionToThrow et) throws MyException {
        switch (et) {
            case CHECKED:
                throw new MyException("throwing a beatiful checked exception");
            case RUNTIME:
                throw new MyRuntimeException("throwing a beatiful runtime exception");
        }
    }

    public static 
    void catchExceptions(ExceptionToThrow et){
        try {
            throwExceptions(et);
        } catch(MyException e) {
            System.out.println(String.format("My exception %s", e.getMessage()));
        } catch (MyRuntimeException e) {
            System.out.println(String.format("My exception %s", e.getMessage()));
        } catch (Exception e) {
            System.out.println(String.format("Other exception %s", e.getMessage()));
        }
    }
}