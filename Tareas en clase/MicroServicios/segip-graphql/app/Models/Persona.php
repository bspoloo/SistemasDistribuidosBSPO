<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Persona extends Model
{
    protected $table = "personas";
    protected $fillable = [
        "id",
        "nombres",
        "ci",
        "primer_apellido",
        "segundo_apellido",
    ];
}
