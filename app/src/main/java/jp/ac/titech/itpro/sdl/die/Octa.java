package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octa implements Obj {

    private final static float[] VERTICES = {
        // upper-front
        0, 1, 0,
        -1, 0, 1,
        1, 0, 1,
        // upper-right
        0, 1, 0,
        1, 0, 1,
        1, 0, -1,
        // upper-left
        0, 1, 0,
        -1, 0, 1,
        -1, 0, -1,
        // upper-back
        0, 1, 0,
        1, 0, -1,
        -1, 0, -1,
        // lower-front
        0, -1, 0,
        1, 0, 1,
        -1, 0, 1,
        // lower-right
        0, -1, 0,
        1, 0, 1,
        1,0, -1,
        // lower-left
        0, -1, 0,
        -1, 0, 1,
        -1, 0, -1,
        // lower-back
        0, -1, 0,
        1, 0, -1,
        -1, 0, -1
    };

    private final FloatBuffer vbuf;

    Octa() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // upper-front
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // upper-right
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // upper-left
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // upper-back
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // lower-front
        gl.glNormal3f(0,-1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // lower-right
        gl.glNormal3f(1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // lower-left
        gl.glNormal3f(-1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // lower-back
        gl.glNormal3f(0, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);
    }
}
