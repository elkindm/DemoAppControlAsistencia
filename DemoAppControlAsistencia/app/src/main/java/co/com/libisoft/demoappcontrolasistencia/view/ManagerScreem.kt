package co.com.libisoft.demoappcontrolasistencia.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.maps.android.compose.GoogleMap

@Composable
fun ManagerScreem(
    navegarInicio:()->Unit,fusedLocationProviderClient: FusedLocationProviderClient
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       // TestoAdminScreem()
        //btnInicio(navegarInicio)
        GoogleMapas()
    }
}

@Composable
fun GoogleMapas() {
   GoogleMap(Modifier.fillMaxSize())
}

@Composable
fun btnInicio(navegarInicio: () -> Unit) {
    Button(onClick = { navegarInicio() }) {
        Text(text = "Volver")
    }
}

@Composable
fun TestoAdminScreem() {
    Text(text = "Pantalla Administrador")
}
