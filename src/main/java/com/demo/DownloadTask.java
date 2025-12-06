package com.demo;
// 下载任务类
public class DownloadTask implements Runnable{
    private String fileUrl;
    private String fileName;

    public DownloadTask(String fileUrl, String fileName) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " 开始下载：" + fileName);
            // 模拟网络IO耗时（2秒）
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " 完成下载：" + fileName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
