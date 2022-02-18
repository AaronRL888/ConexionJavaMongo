package conexionjavamongo;
/**
 *
 * @author Aaron
 */
public class ConexionJavaMongo {

    public static void main(String[] args) {
        Conexion conec = new Conexion();
//        conec.insertar("Motorola");
//        conec.Mostrar(); 
//        conec.Actualizar("Motorola","Xiaomi");
//        conec.Mostrar(); 
        conec.Eliminar("Xiaomi");
        conec.Mostrar();
    }
}