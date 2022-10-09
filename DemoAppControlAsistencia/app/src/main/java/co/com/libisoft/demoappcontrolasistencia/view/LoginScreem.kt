package co.com.libisoft.demoappcontrolasistencia.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreem(
    navegarEmpleado:()->Unit,
    navegarAdmin: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TestoLoginScreem()
        Row() {
            btnAdminScreem(navegarAdmin)
            btnEmpleadoScreem(navegarEmpleado)
        }

    }
}

@Composable
fun btnEmpleadoScreem(navegarEmpleado: () -> Unit) {
    Button(onClick = { navegarEmpleado() }) {
        Text(text = "Empleado")
    }
}

@Composable
fun btnAdminScreem(navegarAdmin: () -> Unit) {
    Button(onClick = { navegarAdmin() }) {
        Text(text = "Administrador")
    }
}

@Composable
fun TestoLoginScreem() {
    Text(text = "Pantalla inicio")
}
