package local.oop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Timer;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import local.oop.events.PlayerInputProcessor;
import local.oop.events.WindowInputProcessor;
import local.oop.model.Arena;
import local.oop.model.ArenaImpl;
import local.oop.presenter.PlayerManager;
import local.oop.presenter.PlayerManagerImpl;
import local.oop.presenter.Presenter;
import local.oop.presenter.PresenterImpl;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PlayerManager.class).to(PlayerManagerImpl.class);
        bind(Presenter.class).to(PresenterImpl.class);
        bind(Arena.class).to(ArenaImpl.class);
        bind(InputProcessor.class).annotatedWith(Names.named("PlayerInputProcessor")).to(PlayerInputProcessor.class);
        bind(InputProcessor.class).annotatedWith(Names.named("WindowInputProcessor")).to(WindowInputProcessor.class);
        bind(Game.class).to(GameImpl.class);
    }
}
