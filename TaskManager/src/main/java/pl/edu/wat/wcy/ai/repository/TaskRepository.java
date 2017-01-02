package pl.edu.wat.wcy.ai.repository;

import pl.edu.wat.wcy.ai.domain.Task;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Task entity.
 */
@SuppressWarnings("unused")
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("select task from Task task where task.owner.login = ?#{principal.username}")
    List<Task> findByOwnerIsCurrentUser();

}
