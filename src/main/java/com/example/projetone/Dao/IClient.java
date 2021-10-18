package com.example.projetone.Dao;

import com.example.projetone.Entite.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IClient extends JpaRepository<Client,Long>
{

}

