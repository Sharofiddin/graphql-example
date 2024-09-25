USE [master]
GO

IF DB_ID('order') IS NOT NULL
  set noexec on 

CREATE DATABASE [order];
GO

USE [order]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE LOGIN [migrator] WITH PASSWORD = 'migrator123!'
GO

CREATE SCHEMA app
GO

CREATE USER [migrator] FOR LOGIN [migrator] WITH DEFAULT_SCHEMA=[app]
GO

EXEC sp_addrolemember N'db_owner', N'migrator'
GO

CREATE LOGIN [orderUser] WITH PASSWORD = 'user123!'
GO

CREATE USER [orderUser] FOR LOGIN [orderUser] WITH DEFAULT_SCHEMA=[app]
GO
