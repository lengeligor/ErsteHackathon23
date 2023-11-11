package sk.tuke.pegasus.dto;

import lombok.Data;

@Data
public class GraphResponseDto {

    public String mesiac;
    public double stavUctu;

    public GraphResponseDto(String mesiac, double stavUctu) {
        this.mesiac = mesiac;
        this.stavUctu = stavUctu;
    }
}
