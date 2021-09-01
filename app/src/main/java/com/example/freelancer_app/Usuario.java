public class Usuario{
    int id;
    String nombre;
    String clave;
    String correo;
    String pais;
    String descripción;
    //img imagen (?)


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripción() {
        return this.descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }



    public Usuario(int idc, String nombre, String clave, String correo, String pais, String descripción) {
        this.id = idc;
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.pais = pais;
        this.descripción = descripción;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", clave='" + getClave() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", pais='" + getPais() + "'" +
            ", descripción='" + getDescripción() + "'" +
            "}";
    }

    
}