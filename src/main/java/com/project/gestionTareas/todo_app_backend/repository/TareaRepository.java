package com.project.gestionTareas.todo_app_backend.repository;


import com.project.gestionTareas.todo_app_backend.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {


}
