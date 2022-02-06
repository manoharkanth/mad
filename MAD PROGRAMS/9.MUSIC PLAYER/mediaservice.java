import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import androidx.annotation.Nullable;
public class MediaService extends Service {
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public int onStartCommand(Intent intent, int flags, int startId)
    {
       player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        //player = MediaPlayer.create(this,R.raw.song);
        player.setLooping(true);
//staring the player
        player.start();

//start sticky means service will be explicity started and stopped
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
//stopping the player when service is destroyed player.stop();
        player.stop();
    }
}