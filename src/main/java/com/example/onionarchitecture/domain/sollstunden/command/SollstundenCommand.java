package com.example.onionarchitecture.domain.sollstunden.command;

import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SollstundenCommand {
    BeraterSollStunden beraterSollStunden;
}
