package android.wxapp.service.util;

import java.util.HashMap;

import android.wxapp.service.util.HttpDownloadTask;

//fym
public class DownloadMutex
{
	public static HashMap<String, HttpDownloadTask> _download_feedback_tasks = new HashMap<String, HttpDownloadTask>();//��������
	public static HashMap<String, HttpDownloadTask> _download_task_tasks = new HashMap<String, HttpDownloadTask>();//���񸽼�
}
