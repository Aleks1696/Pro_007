
package lan.lesson05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class LanEx01 {

    /* Сетевое взаимодействие
        Protocol - описывает набор правил для интерактивного обмена информацией между компьютерами в рамках сети


        TCP/IP
        Transmisson Control Protocol - основная задача протокола заключается в том, что-бы гарантировать передачу данных между компьютерами в сети
        Internet Protocol - основная задача протокола - решение коммуникационных вопросов, возникающих в процессе передачи данных

        ipV4:
        XXX.XXX.XXX.XXX
        127.0.0.1 - localhost

     */

    public static void main(String[] args) {
        try {
            /*
            SocketChannel - класс необходим для подключения к удаленному ресурсу
            hostname - адрес ПК в сети
            port - любой в диапазоне ( 0 (8081) - 65535)
             */
            SocketChannel channel = SocketChannel.open(
                    new InetSocketAddress("127.0.0.1", 20000) //192.168.1.148
            );

            String text = "Адин два три";

            ByteBuffer buffer = ByteBuffer.allocate(128);
            buffer.put(text.getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
