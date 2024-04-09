package DTO;

public class ContratacionDTO {
    private String titulo_vacante;
    private String descripcion_vacante;
    private String nombre_empresa;
    private String ubicacion_empresa;
    private String nombre_coder;
    private String apellidos_coder;
    private String documento_coder;
    private String tecnologia_coder;
    private String salario;

    public ContratacionDTO() {
    }

    public ContratacionDTO(String titulo_vacante, String descripcion_vacante, String nombre_empresa, String ubicacion_empresa, String nombre_coder, String apellidos_coder, String documento_coder, String tecnologia_coder, String salario) {
        this.titulo_vacante = titulo_vacante;
        this.descripcion_vacante = descripcion_vacante;
        this.nombre_empresa = nombre_empresa;
        this.ubicacion_empresa = ubicacion_empresa;
        this.nombre_coder = nombre_coder;
        this.apellidos_coder = apellidos_coder;
        this.documento_coder = documento_coder;
        this.tecnologia_coder = tecnologia_coder;
        this.salario = salario;
    }

    public String getTitulo_vacante() {
        return titulo_vacante;
    }

    public void setTitulo_vacante(String titulo_vacante) {
        this.titulo_vacante = titulo_vacante;
    }

    public String getDescripcion_vacante() {
        return descripcion_vacante;
    }

    public void setDescripcion_vacante(String descripcion_vacante) {
        this.descripcion_vacante = descripcion_vacante;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getUbicacion_empresa() {
        return ubicacion_empresa;
    }

    public void setUbicacion_empresa(String ubicacion_empresa) {
        this.ubicacion_empresa = ubicacion_empresa;
    }

    public String getNombre_coder() {
        return nombre_coder;
    }

    public void setNombre_coder(String nombre_coder) {
        this.nombre_coder = nombre_coder;
    }

    public String getApellidos_coder() {
        return apellidos_coder;
    }

    public void setApellidos_coder(String apellidos_coder) {
        this.apellidos_coder = apellidos_coder;
    }

    public String getDocumento_coder() {
        return documento_coder;
    }

    public void setDocumento_coder(String documento_coder) {
        this.documento_coder = documento_coder;
    }

    public String getTecnologia_coder() {
        return tecnologia_coder;
    }

    public void setTecnologia_coder(String tecnologia_coder) {
        this.tecnologia_coder = tecnologia_coder;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "ContratacionDTO{" +
                "titulo_vacante='" + titulo_vacante + '\'' +
                ", descripcion_vacante='" + descripcion_vacante + '\'' +
                ", nombre_empresa='" + nombre_empresa + '\'' +
                ", ubicacion_empresa='" + ubicacion_empresa + '\'' +
                ", nombre_coder='" + nombre_coder + '\'' +
                ", apellidos_coder='" + apellidos_coder + '\'' +
                ", documento_coder='" + documento_coder + '\'' +
                ", tecnologia_coder='" + tecnologia_coder + '\'' +
                ", salario='" + salario + '\'' +
                '}';
    }
}
