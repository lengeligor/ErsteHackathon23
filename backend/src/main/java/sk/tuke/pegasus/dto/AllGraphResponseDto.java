package sk.tuke.pegasus.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class AllGraphResponseDto {
    private String graphType;
    private List<GraphResponseDto> graphs = new ArrayList<GraphResponseDto>();

    public AllGraphResponseDto(String graphType, List<GraphResponseDto> graphs) {
        this.graphType = graphType;
        this.graphs = graphs;
    }
}
