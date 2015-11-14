package jp.co.app.dream.physicsdream;

import android.graphics.Color;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class MainActivity extends SimpleBaseGameActivity {

    private Font font;

    @Override
    protected void onCreateResources() {
        font = FontFactory.create(getFontManager(), getTextureManager(),
                256, 256, 32, true, Color.WHITE);
        font.load();
    }

    @Override
    protected Scene onCreateScene() {
        Scene scene = new Scene();
        //scene.setBackground(new Background(android.graphics.Color.CYAN));
        Text text = new Text(100, 100, font, "Hello AndEngine!!",
                getVertexBufferObjectManager());

        scene.attachChild(text);
        return scene;
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        Camera camera = new Camera(0, 0, 480, 800);
        return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
                new RatioResolutionPolicy(480, 800), camera);
    }
}