package jugadorTarro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Dibujable;
import com.mygdx.game.GameScreen;
import com.mygdx.game.Movible;


public final class Tarro implements Dibujable{
	private static Tarro instance;
    private Rectangle bucket;
    private Texture bucketImage;
    private Sound sonidoHerido;    
    private int velX = 400;
    private boolean herido = false;
    private int tiempoHeridoMax=50;
    private int tiempoHerido;
    private float anchoCam;
    private float tiempoRelentizadoEfec;
    // temporal
    private boolean relentizadoHabilidad;
    private boolean relentizadoEfec;


    private Tarro(Texture tex, Sound ss) {
        bucketImage = tex;
        sonidoHerido = ss;
        this.anchoCam = GameScreen.getAnchoCam();
        relentizadoHabilidad = false;
        relentizadoEfec = false;
        
        tiempoRelentizadoEfec = 0f;
    }
    
    public static Tarro getTarro() {
    	if (instance == null) {
    		instance = new Tarro(new Texture(Gdx.files.internal("bucket.png")),Gdx.audio.newSound(Gdx.files.internal("hurt.ogg")));
    	}
    	return instance;
    }
    
    @Override
    public Rectangle getArea() {
        return bucket;
    }

    public void crear() {
        bucket = new Rectangle();
        bucket.x = anchoCam / 2 - 64 / 2;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;
    }
    
    public void dañar() {
        herido = true;
        tiempoHerido=tiempoHeridoMax;
        sonidoHerido.play();
    }
    
    @Override
    public void actualizarDibujo(SpriteBatch batch) {
        if (!herido)  
            batch.draw(bucketImage, bucket.x, bucket.y);
        
        else {
            batch.draw(bucketImage, bucket.x, bucket.y+ MathUtils.random(-5,5));
            tiempoHerido--;
            if (tiempoHerido<=0) herido = false;
        }
    }

    @Override
    public void actualizarMov() { 
        //movimiento desde teclado
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= velX * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += velX * Gdx.graphics.getDeltaTime();
        
        revisarEfecto();
        // que no se salga de los bordes izq y der
        if(!dentroPantalla()) {
        	if (bucket.x < 0) {
        		bucket.x = 0;
        	}
        	else {
        		bucket.x = anchoCam - 64;
        	}
        }
    }
    
    public void setEfectoSlow(float tt) {
    	tiempoRelentizadoEfec = tt;
    	relentizadoEfec();
    }
    
    public void revisarEfecto() {
    	tiempoRelentizadoEfec -= Gdx.graphics.getDeltaTime();
    	if (tiempoRelentizadoEfec <= 0) {
    		acelerarEfec();
    	}
    }
    
    @Override
    public boolean dentroPantalla() {
    	if (bucket.x < 0) 
    		return false;
    	if (bucket.x > anchoCam - 64) {
    		return false;
    	}
    	return true;
    }

    public void destruir() {
        bucketImage.dispose();
        instance = null;
    }
	
    public boolean estaHerido() {
        return herido;
    }

	@Override
	public boolean colision(Movible obj) {
		if (bucket.overlaps(obj.getArea())) {
			return true;
		}
		return false;
	}

	@Override
	public void acelerar() {
		if (relentizadoHabilidad) {
			velX *= 2;
			relentizadoHabilidad = false;
		}
	}

	@Override
	public void relentizar() {
		if (!relentizadoHabilidad) {
			velX /= 2; 
			relentizadoHabilidad = true;
		}
	}
	
	public void relentizadoEfec() {
		if (!relentizadoEfec) {
			velX /= 2;
			relentizadoEfec = true;
		}
	}
	
	public void acelerarEfec() {
		if (relentizadoEfec) {
			velX *= 2;
			relentizadoEfec = false;
		}
	}
}
