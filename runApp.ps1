$ipAdresses = Get-NetIPAddress -AddressState Preferred | Select-Object -ExpandProperty IPAddress
$i = 0
docker-compose build
foreach ($ipAdress in $ipAdresses)
{
    $DISPLAY = -join($ipAdress, ":0") 
    docker-compose run -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix maingui 2> erroutput.txt
    if ($LastExitCode -eq 0 -or $LastExitCode -eq 130) {
        break
    }
}
docker-compose down