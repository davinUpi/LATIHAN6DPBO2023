# LATIHAN6DPBO2023

## Saya Davin mengerjakan evaluasi LATIHAN6DPBO2023 dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

ini yang game logic/ synchronaziation (stroke)

### PENAMBAHAN SCORE
Pada kodingan sebelumnya, score di hard-code berdasarkan arahnya. Pendekatan tersebut tidak lagi dapat memenuhi kebutuhan kita.<br>
Oleh karena itu, kami menambahkan suatu fungsi guna menambahkan score yang terdapat pada kelas Game. Berikut adalah fungsinya
~~~
public class Game extends Canvas implements Runnable{

  ...
  public void addScore(int delta_Score){
    score += delta_Score
  }
  
  ...

}
~~~

Fungsi tersebut menambahkan score sebesar delta_Score. Delta_score sendiri adalah besar perbedaan score. Bila diperhatikan lebih baik, fungsi ini dapat dijabarkan sebagai berikut

~~~
  score = score + delta_score
~~~

Sehingga, fungsi tersebut dapat diterapkan tidak hanya untuk menambahkan score, namun juga untuk mengurangi score bila delta_score diisi dengan bilangan negatif.

~~~
score = score + (-delta_score)
score = score - delta_score
score -= delta_score (QED)
~~~


### ENUM MOVE
Sebuah public enum yang ditambahkan pada controller. Hal tersebut digunakan untuk mengetahui arah pergerakan player.

### SCORE SAAT BELOK

Sebelumnya, kami perlu mendefinisikan belok.<br>
Belok saya definisikan sebagai perubahan aerah gerak, misalnya yang awalnya ke kiri jadi ke bawah, etc. Disini juga saya mendefinisikan belok bila dari keadaan diam berlaju ke arah tertentu yang tidak ama dengan arah sebelumnya. Misalkan, player bergerak ke kanan lalu berhenti. Bila player bergerak ke kanan <b>lagi</b>, maka player <b>tidak</b> belok. Namun, bila player bergerak ke arah selain kanan, maka player dinyatakan berbelok.

Dengan menggunakan enum yang di atas, kita dapat mengimplementasikan hal tersebut. Perhatikan contoh kode di bawah ini

~~~
  public Controller extends KeyAdapter implements KeyListener{
  
    ...
  
    private MOVE move;
  
    ...
    
    public enum MOVE{
      LEFT,
      RIGHT,
      UP,
      DOWN,
      NONE;
    }
  
    ...
    
    @Override
    public synchronized void keyPressed(KeyEvent e)
    {
        System.out.println("Pressed");
        
        // Get key code (what key that pressed?).
        int key = e.getKeyCode();
        if(game.isRunning())
        {
            // Searching for player object.
            int i = 0; boolean found = false;
            while((found == false) && (i < handler.count()))
            {
                if(handler.get(i).getType().equals("Player"))
                {
                    found = true;
                }
                else
                {
                    i++;
                }
            }
            
            // Set the object and do the handling.
            GameObject temp = handler.get(i);
            MOVE tempMove = MOVE.NONE;
            if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP))
            {
                // Move up.
                temp.setVelY(-5);
                tempMove = MOVE.UP;
            }
            if((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT))
            {
                // Move left.
                temp.setVelX(-5);
                tempMove = MOVE.LEFT;
            }
            if((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN))
            {
                // Move down.
                temp.setVelY(+5);
                tempMove = MOVE.DOWN;
            }
            if((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT))
            {
                // Move right.
                temp.setVelX(+5);
                tempMove = MOVE.RIGHT;
            }
            
            if((move != tempMove) && (tempMove != MOVE.NONE)){
                move = tempMove;
                game.addScore(1);
            }
        }
    }
  
  }
~~~

Terdapat atribut baru pada Controller yaitu MOVE move, yang diinisialisasi pada constructor dengan value MOVE.NONE. Kemudian, pada pemencetan tombol, terdapat var tempMove yang diisi dengan NONE untuk menghindari null. Setiap kali pengguna memencet tombol gerak, contohnya 'W' atau 'UP', maka tempMove akan memiliki nilai enum MOVE sesuai dengan arahnya. Di akhir metode pencet tombol, terdapat gerbang yang mengecek apakah nilai tempMove sama dengan move (artinya, arahnya sama) dan apakah tempMove = MOVE.NONE (player tidak bergerak). Bila tempMove =/= move, maka artinya player telah berbelok, sehingga menambahkan score 1 dan move = tempMove. Bila diperhatikan secara lebih dalam, move tidak akan pernah memiliki nilai MOVE.NONE kecuali di awal instansiasi.

Definisi belok yang telah disebutkan juga berfungsi terhadap diagonal juga. (dont ask me, black magic)
