package fr.gobelins.dmi1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity() {
    private lateinit var btnCompute: Button
    private lateinit var firstOperand: EditText
    private lateinit var secondOperand: EditText
    private lateinit var operation: EditText
    private lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        btnCompute = findViewById(R.id.btn_compute)
        firstOperand = findViewById(R.id.first_operand)
        secondOperand = findViewById(R.id.second_operand)
        operation = findViewById(R.id.operation)
        result=findViewById(R.id.result)
        //val operation = intent.getStringExtra("operation") ?: "ADD"

        //Au click du bouton compute
        btnCompute.setOnClickListener {
            var resultat=0
            var op=true
            if (operation.getText().toString().lowercase()=="add"){
                resultat= firstOperand.getText().toString().toInt()+secondOperand.getText().toString().toInt()
            }else if (operation.getText().toString().lowercase()=="subs"){
                resultat= firstOperand.getText().toString().toInt()-secondOperand.getText().toString().toInt()
            }else if (operation.getText().toString().lowercase()=="div"){
                resultat= firstOperand.getText().toString().toInt()/secondOperand.getText().toString().toInt()
            }else if (operation.getText().toString().lowercase()=="mult"){
                resultat= firstOperand.getText().toString().toInt()*secondOperand.getText().toString().toInt()
            }else{
                op=false
                result.text =  "L'opération choisie n'est pas prise en compte."
            }
            if (op) {
                result.text = "Result: $resultat"
            }
        }
    }
}