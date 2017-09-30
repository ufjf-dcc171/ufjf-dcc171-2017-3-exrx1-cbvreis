
package descricaolatitude;

import java.util.Date;


class Eventos {
    private String latitude;
    private String longitude;
    private Date data;
    private String descricao;

    public Eventos(String latitude, String longitude, Date data, String descricao) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
        this.descricao = descricao;
    }

    public Eventos() {
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "latitude=" + latitude + " longitude=" + longitude  + data +" " + descricao ;
    }
        
    
    
}
