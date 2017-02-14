package fcmtest;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class TEST {
	public static void main(String a[]) throws Exception {
		String serverKey = "AAAA21aJjGM:APA91bGP8BIt_gB562WMVtt8yxG33d-4pqog6cvs_yIsrh7GyXUX0HPUqwpJaMXRcQAx3f7Iob9z_ivyrDX9dn3BzZCrAsPQpshsH3WHe3eS5eD6KGHAqwK_GTaosdPz39RtFD3Xi4bQp8Yl5zgsBxOI3W6FZ3uU1w";
		
		Thread thread = new Thread() {
			public void run(){
				try{
					Sender sender = new FCMSender(serverKey);
					
					Message message = new Message.Builder()
                            .collapseKey("message")
                            .timeToLive(3)
                            .delayWhileIdle(true)
                            .addData("message", "Notification from Java application")
                            .build();  
					
					//Result result = sender.send(message, "dbjx7oMmn0E:APA91bHvBNh0q2rQBweUoTidYjx57YIyrJgu5ZBnCdsqFthaLQYbx0z1yQYLA9bQP9P6sJkqfP6NuSUsH0m5vx4wAGVKedD4MMpYEljc6CjzaQNPfgQEx7o2COH8czkujz46fGy1pnG5", 1);
					Result result = sender.send(message, "/topics/notice", 1);
					
					System.out.println("Result: " + result.toString());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		};
		
		thread.start();
		
		try{
			thread.join();
		}catch (InterruptedException iex) {
            iex.printStackTrace();
        }
	}

}
