<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Pronostico extends Model
{
    /** @use HasFactory<\Database\Factories\PronosticoFactory> */
    use HasFactory;
    protected $table = "pronosticos";
    protected $fillable = [
        "fecha",
        "cantidad_estimada"
    ];
}
