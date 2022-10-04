package com.example.movie.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieEntity {
    @NonNull
    private Long id;
    private String name;
    private String description;
}
