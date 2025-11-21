<?php

namespace Database\Seeders;

use App\Models\Pronostico;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class PronosticoSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $datas = [
            ["fecha" => "2025-06-01", "cantidad_estimada" => 150],
            ["fecha" => "2025-06-02", "cantidad_estimada" => 145],
            ["fecha" => "2025-06-03", "cantidad_estimada" => 165],
            ["fecha" => "2025-06-04", "cantidad_estimada" => 170],
            ["fecha" => "2025-06-05", "cantidad_estimada" => 180],
            ["fecha" => "2025-06-06", "cantidad_estimada" => 130],
            ["fecha" => "2025-06-07", "cantidad_estimada" => 160],
            ["fecha" => "2025-06-08", "cantidad_estimada" => 190],
            ["fecha" => "2025-06-09", "cantidad_estimada" => 200],
        ];

        foreach($datas as $data) {
            Pronostico::create([
                "fecha" => $data["fecha"],
                "cantidad_estimada" => $data["cantidad_estimada"]
            ]);
        }
    }
}
