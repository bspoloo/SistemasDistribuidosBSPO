<?php

declare(strict_types=1);

namespace App\GraphQL\Types;

use App\Models\Persona;
use GraphQL\Type\Definition\Type;
use Rebing\GraphQL\Support\Type as GraphQLType;

class PersonaType extends GraphQLType
{
    protected $attributes = [
        'name' => 'Persona',
        'description' => 'persona',
        'model' => Persona::class
    ];

    public function fields(): array
    {
        return [
            'id' => [
                'type' => Type::nonNull(Type::int()),
                'description' => 'El ID de la persona',
            ],
            'ci' => [
                'type' => Type::string(),
                'description' => 'Carnet de identidad',
            ],
            'nombres' => [
                'type' => Type::string(),
                'description' => 'Nombres de la persona',
            ],
            'primer_apellido' => [
                'type' => Type::string(),
                'description' => 'Apellidos de la persona',
            ],
            'segundo_apellido' => [
                'type' => Type::string(),
                'description' => 'Apellidos de la persona',
            ],
        ];
    }
}
