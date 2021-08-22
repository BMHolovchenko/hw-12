@Repeat(executions = 3)
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello!");
    }
    public static void main(String[] args) {
        CustomThreadPoolExecutor customThreadPoolExecutor =
                new CustomThreadPoolExecutor (10);
        customThreadPoolExecutor.execute (new MyRunnable ());
        customThreadPoolExecutor.shutdown ();
    }
}