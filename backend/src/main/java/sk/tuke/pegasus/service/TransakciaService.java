package sk.tuke.pegasus.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import sk.tuke.pegasus.dto.AllGraphResponseDto;
import sk.tuke.pegasus.dto.GraphFilterDto;
import sk.tuke.pegasus.dto.GraphResponseDto;
import sk.tuke.pegasus.entity.Transakcia;
import sk.tuke.pegasus.repository.TransakciaRepository;

@Service
public class TransakciaService {

    private TransakciaRepository transakciaRepository;

    private String arr[] = {"Nov-23", "Dec-23", "Jan-24", "Feb-24", "Mar-24", "Apr-24", "Maj-24"};
    private double noFilter[] = {1089.73, 1023.0, 754.06, 824.52, 773.09, 685.77, 735.0};
    private double noDisney[] = {1345.05, 726.12, 602.08, 693.11,  1364.97,954.10,1115.71};
    private double noNetflix[] = {1398.41,  754.945, 793.12,1516.7,1119.8,1268.96};
    private double halfHazard[] = {1915.4,1162.66,1894.1,1602.37,1054.34,1501.65,1439.76};

    private double lessShoping[] = {1183.24,507.6,1362.40,769.92,962.24,895.94,1245.59};

    private Set<String> months = new HashSet<>(Arrays.asList(arr));

    public TransakciaService(@NonNull TransakciaRepository transakciaRepository){
        this.transakciaRepository = transakciaRepository;
    }

    public List<Transakcia> getTransactions(){
        return transakciaRepository.findAll();
    }

    public List<AllGraphResponseDto> getGraph() {

        List<AllGraphResponseDto> response = new ArrayList<>();
        response.add(new AllGraphResponseDto("no_filter",getGraphForFill(noFilter)));
        response.add(new AllGraphResponseDto("no_disney",getGraphForFill(noDisney)));
        response.add(new AllGraphResponseDto("no_netflix",getGraphForFill(noNetflix)));
        response.add(new AllGraphResponseDto("half_hazard",getGraphForFill(halfHazard)));
        response.add(new AllGraphResponseDto("less_shoping",getGraphForFill(lessShoping)));
        return response;
    }


    public List<GraphResponseDto> getGraphForFill(double [] filter) {
        List<GraphResponseDto> graphs = new ArrayList<>();


        for(int i = 0; i<6;i++){
            graphs.add(new GraphResponseDto(arr[i],filter[i]));
        }

        return graphs;
    }
}
