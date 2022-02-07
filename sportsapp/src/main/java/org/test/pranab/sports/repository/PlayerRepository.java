package org.test.pranab.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.pranab.sports.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
