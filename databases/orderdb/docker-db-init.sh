sleep 30s
echo "running set up script"
/opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P SwN12345678 -d master -i /opt/order-db-init.sql -C
