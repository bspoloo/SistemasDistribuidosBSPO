<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Factura extends Model
{
    /** @use HasFactory<\Database\Factories\FacturaFactory> */
    use HasFactory;
    protected $table = "facturas";
    protected $fillable = [
        "ci",
        "nombres",
        "primer_apellido",
        "segundo_apellido",
        "monto"
    ];
}
