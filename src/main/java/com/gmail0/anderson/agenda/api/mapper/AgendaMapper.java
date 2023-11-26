package com.gmail0.anderson.agenda.api.mapper;

import com.gmail0.anderson.agenda.api.request.AgendaRequest;
import com.gmail0.anderson.agenda.api.response.AgendaResponse;
import com.gmail0.anderson.agenda.domain.entities.Agenda;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AgendaMapper {

    private final ModelMapper mapper;

    public Agenda toAgenda(AgendaRequest request) {
        return mapper.map(request, Agenda.class);
    }

    public AgendaResponse toAgendaResponse(Agenda agenda) {
        return mapper.map(agenda, AgendaResponse.class);
    }

    public List<AgendaResponse> toAgendaResponseList(List<Agenda> agenda) {
        return agenda.stream()
                .map(this::toAgendaResponse)
                .collect(Collectors.toList());
    }
}
