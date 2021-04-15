$ipAdresses = Get-NetIPAddress -AddressState Preferred | Select-Object -ExpandProperty IPAddress
foreach ($ipAdress in $ipAdresses)
{
    $DISPLAY = -join($ipAdress, ":0") 
    docker run -it --privileged -e DISPLAY=$DISPLAY asap397/set-display > $null 2>&1
    if ($LastExitCode -eq 0 -or $LastExitCode -eq 130) {
        $dispLine = "DISPLAY=${DISPLAY}"
        Set-Content -Path "./.env" -Value $dispLine
        break
    }
}
