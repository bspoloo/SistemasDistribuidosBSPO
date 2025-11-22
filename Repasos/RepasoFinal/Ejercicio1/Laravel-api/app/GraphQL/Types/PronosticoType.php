<?php

declare(strict_types=1);

namespace App\GraphQL\Types;

use App\Models\Pronostico;
use Rebing\GraphQL\Support\Type as GraphQLType;
use GraphQL\Type\Definition\Type;

class PronosticoType extends GraphQLType
{
    protected $attributes = [
        'name' => 'Pronostico',
        'description' => 'A type',
        'model' => Pronostico::class,
    ];

    public function fields(): array
    {
        return [
            'id' => [
                'type' => Type::nonNull(Type::int()),
                'description' => 'The id of the pronostico',
            ],
            'fecha' => [
                'type' => Type::string(),
                'description' => 'The fecha of the pronostico',
            ],
            'cantidad_estimada' => [
                'type' => Type::int(),
                'description' => 'The cantidad_estimada of the pronostico',
            ],
        ];
    }
}
