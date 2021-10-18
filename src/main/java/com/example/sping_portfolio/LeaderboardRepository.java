package com.example.sping_portfolio;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource (collectionResourceRel = "leaderboard", path = "leaderboard")
@Repository
public interface LeaderboardRepository extends PagingAndSortingRepository<Participant, Integer>{
    Participant findByRank(@Param("rank") int rank);
}
