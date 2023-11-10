package sk.tuke.pegasus.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import sk.tuke.pegasus.dto.GraphFilterDto;
import sk.tuke.pegasus.dto.GraphResponseDto;
import sk.tuke.pegasus.entity.Transakcia;
import sk.tuke.pegasus.repository.TransakciaRepository;

@Service
public class TransakciaService {

    private TransakciaRepository transakciaRepository;

    private String arr[] = {"Január", "Február", "Marec", "Máj", "", "", "", "", "", "", "", ""};
    private Set<String> months = new HashSet<>(Arrays.asList(arr));

    public TransakciaService(@NonNull TransakciaRepository transakciaRepository){
        this.transakciaRepository = transakciaRepository;
    }

    public List<Transakcia> getTransactions(){
        return transakciaRepository.findAll();
    }

    public List<GraphResponseDto> getGraph(GraphFilterDto filter) {
        List<GraphResponseDto> response = new ArrayList<>();

        return response;
    }
}
