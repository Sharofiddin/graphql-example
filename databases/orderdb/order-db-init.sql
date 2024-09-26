USE [master]
GO

IF DB_ID('order') IS NOT NULL
  set noexec on 

CREATE DATABASE [order];

